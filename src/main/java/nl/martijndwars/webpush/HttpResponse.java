package nl.martijndwars.webpush;

public class HttpResponse {

    private StatusLine statusLine;

    public HttpResponse(int statucCode) {
        statusLine = new StatusLine(statucCode);
    }

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public class StatusLine {
        private int statusCode;

        public StatusLine(int statusCode) {
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }
}
