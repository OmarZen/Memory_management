public class Partition {

    public String Pname;
    public int  Psize;

    Partition()
    {
        Pname="DNE";
        Psize=0;
    }
    public void setPname(String pname) {
        Pname = pname;
    }

    public void setPsize(int psize) {
        Psize = psize;
    }

    public int getPsize() {
        return Psize;
    }

    public String getPname() {
        return Pname;
    }
}
