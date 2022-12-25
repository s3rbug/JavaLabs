package lab10_2;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncodingOutputStream extends FilterOutputStream {
    char keySymbol;

    public EncodingOutputStream(OutputStream out, char keySymbol) {
        super(out);
        this.keySymbol = keySymbol;

        Main.logger.info(Main.labelWithColon("createdEncodingOutputStream") + "'" + keySymbol + "'");
    }

    @Override
    public void write(int data) throws IOException {
        super.write(data - (int) keySymbol);

        Main.logger.info(Main.labels.getString("write") + " " + data + " " + Main.labels.getString("encodedUsing") + " '" + keySymbol + "' " + Main.labels.getString("to") + " " + (data - (int) keySymbol));
    }
}
