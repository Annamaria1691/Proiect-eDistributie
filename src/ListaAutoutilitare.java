import java.util.TreeSet;

public class ListaAutoutilitare {
private TreeSet<Autoutilitara> ts;
private static ListaAutoutilitare lc;

   private ListaAutoutilitare(){
       ts=new TreeSet<>();
       setNumarAutoutilitara();
    }
    private void setNumarAutoutilitara(){
        for(int i=1;i<=6;i++){
            Autoutilitara c=new Autoutilitara();
            c.setNumar(i);
            ts.add(c);
        }
    }

    public TreeSet<Autoutilitara> getAutoutilitara() {
        return ts;
    }
    public static ListaAutoutilitare getInstance(){
       if(lc==null){
           lc=new ListaAutoutilitare();
       }
       return lc;
    }
}
