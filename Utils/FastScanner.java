import java.io.*;
import java.nio.charset.StandardCharsets;

public class FastScanner {
    private InputStream stdin;
    private byte[] buffer = new byte[4096];
    private int bufferSize = 0;
    private int bufferPointer = 0;
    private byte[] input = new byte[32];
    private int inputPointer = 0;
    private int inputLength = 0;

    public FastScanner() {
        stdin = new FileInputStream(FileDescriptor.in);
    }

    private void nextBytesInternal() {
        try {
            while(true){
                if(bufferPointer >= bufferSize) {
                    bufferSize = stdin.read(buffer, 0, 4096);
                    bufferPointer = 0;
                }
                if(inputPointer >= input.length) {
                    byte[] newInput = new byte[inputPointer * 2 + 1];
                    if(input.length < 24) {
                        for(int i = 0; i < input.length; ++i) {
                            newInput[i] = input[i];
                        }
                    }
                    else {
                        System.arraycopy(input, 0, newInput, 0, input.length);
                    }
                    input = newInput;
                }
                byte c = buffer[bufferPointer++];
                if(bufferSize < 0 || c == (byte)'\n' || c == (byte)' ') {
                    inputLength = inputPointer;
                    inputPointer = 0;
                    return;
                }
                input[inputPointer++] = c;
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String next() {
        nextBytesInternal();
        return new String(input, 0, inputLength, StandardCharsets.US_ASCII);
    }

    public byte[] nextBytes() {
        nextBytesInternal();
        byte[] newArray = new byte[inputLength];
        if(inputLength < 24) {
            for(int i = 0; i < inputLength; ++i) {
                newArray[i] = input[i];
            }
        }
        else {
            System.arraycopy(input, 0, newArray, 0, inputLength);
        }
        return newArray;
    }

    public int nextInt() {
        nextBytesInternal();
        int val = 0;
        int mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        return val * mul;
    }

    public long nextLong() {
        nextBytesInternal();
        long val = 0;
        int mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        return val * mul;
    }

}
