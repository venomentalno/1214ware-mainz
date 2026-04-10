#!/usr/bin/env python3
"""
sort_classes.py  –  Paste ported Minecraft class batches and this script
                    will write each class to the correct file path.

Usage:
    python sort_classes.py <input_file>       # read from file
    python sort_classes.py                    # read from stdin  (paste + Ctrl-D)

The input must use the same separator format used in every batch:
    ================================================
    FILE: src/main/java/com/botclient/SomeClass.java
    ================================================
    <java source code>

The script creates all missing parent directories automatically and
OVERWRITES any file that already exists, so you can safely re-run it.
"""

import os
import sys
import re

# ── separator & file-header pattern ──────────────────────────────────────────
SEP = "=" * 48                        # exactly 48 '=' characters
FILE_LINE_RE = re.compile(r"^FILE:\s+(.+\.java)\s*$")

# ── helpers ───────────────────────────────────────────────────────────────────

def split_blocks(lines: list[str]) -> list[tuple[str, list[str]]]:
    """
    Return a list of (relative_path, code_lines) tuples by scanning the
    separator / FILE: / separator triplet that introduces each class.
    """
    blocks: list[tuple[str, list[str]]] = []
    i = 0
    while i < len(lines):
        line = lines[i].rstrip()
        # look for opening separator
        if line == SEP:
            # next non-blank line should be FILE: ...
            j = i + 1
            while j < len(lines) and not lines[j].strip():
                j += 1
            if j >= len(lines):
                break
            m = FILE_LINE_RE.match(lines[j].rstrip())
            if not m:
                i += 1
                continue
            rel_path = m.group(1).strip()
            # skip closing separator
            k = j + 1
            while k < len(lines) and lines[k].rstrip() != SEP:
                k += 1
            # code starts after closing separator
            code_start = k + 1
            # find next opening separator (or EOF) to know where code ends
            code_end = code_start
            while code_end < len(lines):
                if lines[code_end].rstrip() == SEP:
                    # peek ahead: is it a FILE: header?
                    nxt = code_end + 1
                    while nxt < len(lines) and not lines[nxt].strip():
                        nxt += 1
                    if nxt < len(lines) and FILE_LINE_RE.match(lines[nxt].rstrip()):
                        break   # yes – this is the next class block
                code_end += 1
            code_lines = lines[code_start:code_end]
            # strip trailing blank lines
            while code_lines and not code_lines[-1].strip():
                code_lines.pop()
            blocks.append((rel_path, code_lines))
            i = code_end   # continue from here (the outer loop will re-examine SEP)
        else:
            i += 1
    return blocks


def write_block(rel_path: str, code_lines: list[str], base_dir: str) -> None:
    full_path = os.path.join(base_dir, rel_path)
    os.makedirs(os.path.dirname(full_path), exist_ok=True)
    with open(full_path, "w", encoding="utf-8") as fh:
        fh.write("\n".join(line.rstrip() for line in code_lines))
        fh.write("\n")   # ensure final newline
    print(f"  [WROTE]  {full_path}")


# ── entry point ───────────────────────────────────────────────────────────────

def main() -> None:
    if len(sys.argv) >= 2:
        src_file = sys.argv[1]
        print(f"Reading from file: {src_file}")
        with open(src_file, "r", encoding="utf-8", errors="replace") as fh:
            lines = fh.readlines()
    else:
        print("Paste the ported class batch below, then press Ctrl-D (Linux/Mac) or Ctrl-Z + Enter (Windows):")
        lines = sys.stdin.readlines()

    # base dir = directory of this script  (so output mirrors src/main/…)
    base_dir = os.path.dirname(os.path.abspath(__file__))

    blocks = split_blocks(lines)
    if not blocks:
        print("ERROR: no class blocks found – make sure the separators are exactly 48 '=' chars.")
        sys.exit(1)

    print(f"\nFound {len(blocks)} class(es) – writing …\n")
    for rel_path, code_lines in blocks:
        write_block(rel_path, code_lines, base_dir)

    print(f"\nDone. {len(blocks)} file(s) written.")


if __name__ == "__main__":
    main()
