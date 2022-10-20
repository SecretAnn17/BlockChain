class ChristmasTree {

    private String color;

    public ChristmasTree(String color) {
        this.color = color;
    }

    public void putTreeTopper(String color) {
        
        TreeTopper inner = new TreeTopper(color);
        inner.sparkle();
    }

    class TreeTopper {

        private String color;        

        public TreeTopper(String color) {
            this.color = color;
        }

        public void sparkle() {
            if(this.color.equals("silver")||this.color.equals("green")){
                System.out.println("Sparkling silver tree topper looks stunning with green Christmas tree!");
            }
        }
    }
}

// this code should work
class CreateHoliday {

    public static void main(String[] args) {

        ChristmasTree christmasTree = new ChristmasTree("green");
        christmasTree.putTreeTopper("silver");
    }
}
