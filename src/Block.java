import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // the data will be a simple message
    private long timeStamp; // as a number of millisecond

    // Block Constructor
    public Block (String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // new method that make sure we do this method after we set the other values.
    }

    public String calculateHash(){
        String calculatedHash = StringUtil.applySHA256(
            previousHash + Long.toString(timeStamp) + data
        );

        return calculatedHash;
    }

    public String getData(){
        return data;
    }

}


