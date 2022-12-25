package lab10_2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncodingInputStream extends FilterInputStream {
    char keySymbol;

    public EncodingInputStream(InputStream in, char keySymbol) {
        super(in);
        this.keySymbol = keySymbol;

        Main.logger.info(Main.labelWithColon("createdEncodingInputStream") + "'" + keySymbol + "'");
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        if(data == -1){
            Main.logger.info(Main.labelWithColon("skipLineEnd") + "'" + keySymbol + "'");
            return -1;
        }
        Main.logger.info(Main.labels.getString("read") + " " + data + " " + Main.labels.getString("encodedUsing") + " '" + keySymbol + "' " + Main.labels.getString("to") + " " + (data + (int) keySymbol));
        return data + (int) keySymbol;
    }

}
