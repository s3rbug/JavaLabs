package EncodingStream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncodingInputStream extends FilterInputStream {
    char keySymbol;

    public EncodingInputStream(InputStream in, char keySymbol) {
        super(in);
        this.keySymbol = keySymbol;
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        if(data == -1){
            return -1;
        }
        return data + (int) keySymbol;
    }

}
