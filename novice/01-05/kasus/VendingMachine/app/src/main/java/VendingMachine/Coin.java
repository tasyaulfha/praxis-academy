package VendingMachine;

    public enum Coin{
        PENNY(1) , NICKLE(5) , DIME(10) , QUARTER(25);

        private int Denomination;

        private Coin(int Denomination){
            this.Denomination = denomination;
        }
        public int getDenomination(){
            return Denomination;
        }
    }