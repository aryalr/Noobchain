import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // the data will be a simple message
    private long timeStamp; // as a number of millisecond
    private int nonce;

    // Block Constructor
    public Block (String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // new method that make sure we do this method after we set the other values.
    }

    // calculate the hash on the new block that has created
    public String calculateHash(){
        String calculatedHash = StringUtil.applySHA256(
            previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data
        );

        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // create a string with difficulty * 0
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block mined | Hash: " + hash);
    }

}


