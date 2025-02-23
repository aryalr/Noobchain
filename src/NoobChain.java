public class NoobChain {

    public static void main(String[] args) {
        
        Block genesisBlock = new Block("hi im the first block", "0");
        System.out.println("Hash for block 1: " + genesisBlock.hash);
        System.out.println("Block Message: " + genesisBlock.getData() + " | Block hash: " + genesisBlock.hash);
    }

}
