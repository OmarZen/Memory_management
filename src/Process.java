public class Process {


    public String Process_name;
    public int  Process_size;

    public boolean is_allocated;

    Process()
    {
        Process_name="DNE";
        Process_size=0;
        is_allocated=false;
    }

    public void setIs_allocated(boolean is_allocated) {
        this.is_allocated = is_allocated;
    }


    public void setProcess_name(String process_name) {
        Process_name = process_name;
    }

    public void setProcess_size(int process_size) {
        Process_size = process_size;
    }

    public String getProcess_name() {
        return Process_name;
    }

    public int getProcess_size() {
        return Process_size;
    }
    public boolean getIs_allocated()
    {
        return is_allocated;
    }
}
