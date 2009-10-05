    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Ciphers;

    /**
     *
     * @author felipe
     */
    public class Z26 {

        private int val;
        static int[] inverso={1,9,21,15,3,19,0,7,23,11,5,17,25};

        public Z26(){}

        public Z26(int n){
            val=n%26;
            if(val<0)val+=26;
            val=val%26;
        }

        public Z26(char n){

            val=(int)(n-97)%26;
        }

         Z26 suma(Z26 a){

            return new Z26(getVal()+a.getVal());
        }

         Z26 resta(Z26 a){

            return new Z26(getVal()-a.getVal());
        }

        Z26 producto(Z26 a){

            return new Z26(getVal()*a.getVal());
        }


        Z26 inverso(){

            if(getVal()%2==0)return null;
            if(getVal()==13)return null;

            return new Z26(inverso[((getVal()+1)/2)-1]);
        }

        /**
         * @return the val
         */
        public int getVal() {
            return val;
        }

        /**
         * @param val the val to set
         */
        public void setVal(int val) {
            this.val = val%26;
        }

         public static int inver(int a){

            if(a%2==0)return 0;
            if(a==13)return 0;

            return inverso[(a+1)/2-1];
        }

    }
