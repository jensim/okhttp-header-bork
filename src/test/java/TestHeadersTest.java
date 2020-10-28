import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestHeadersTest {

    @Test
    @DisplayName("åäö")
    void swedish() throws IOException {
        final OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .header("my-header", "value with char å")
                .url("http://google.com")
                .build();

        okHttpClient.newCall(request).execute();
    }

    @Test
    @DisplayName("plain")
    void plain() throws IOException {
        final OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .header("my-header", "value with char aaa")
                .url("http://google.com")
                .build();

        okHttpClient.newCall(request).execute();
    }
}
