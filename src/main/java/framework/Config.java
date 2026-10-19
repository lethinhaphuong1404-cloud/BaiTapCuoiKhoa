package framework;

public final class Config {
    private Config() {}
    public static String baseUrl() {
        String url = System.getenv("BASE_URL");
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("Please set BASE_URL to the approved test website URL.");
        }
        return url;
    }
}
