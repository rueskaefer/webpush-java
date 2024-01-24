package nl.martijndwars.webpush;

public class Subscription {
    public String endpoint;
    public Keys keys;
    public String externalId;

    public Subscription() {
        // No-args constructor
    }

    public Subscription(String endpoint, Keys keys) {
        this.endpoint = endpoint;
        this.keys = keys;
    }

    public Subscription(String endpoint, Keys keys, String externalId) {
        this.endpoint = endpoint;
        this.keys = keys;
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "endpoint='" + endpoint + '\'' +
                ", keys=" + keys +
                ", externalId='" + externalId + '\'' +
                '}';
    }

    public static class Keys {
        public String p256dh;
        public String auth;

        public Keys() {
            // No-args constructor
        }

        @Override
        public String toString() {
            return "Keys{" +
                    "p256dh='" + p256dh + '\'' +
                    ", auth='" + auth + '\'' +
                    '}';
        }

        public Keys(String key, String auth) {
            this.p256dh = key;
            this.auth = auth;
        }
    }
}
