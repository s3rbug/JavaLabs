package EncodingStream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncodingOutputStream extends FilterOutputStream {
    char keySymbol;

    public EncodingOutputStream(OutputStream out, char keySymbol) {
        super(out);
        this.keySymbol = keySymbol;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b - (int) keySymbol);
    }
}
