package neo.deobf;

public enum ProxyType {
    SOCKS4,
    SOCKS5,
    HTTP,
    NO_PROXY;

    public static ProxyType getType(String textType) {
        try {
            return ProxyType.valueOf(textType.toUpperCase());
        } catch (Exception ignored) {
            return null;
        }
    }
}
