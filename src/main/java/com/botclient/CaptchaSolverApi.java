/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CaptchaPacket
 *  okhttp3.OkHttpClient
 */
package neo.deobf;

import neo.deobf.CaptchaPacket;
import okhttp3.OkHttpClient;

public interface CaptchaSolverApi {
    public static final OkHttpClient client = new OkHttpClient();

    public void solve(CaptchaPacket var1);
}



