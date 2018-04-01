package csci.impl.testing;

public class Student implements Comparable<Student>{
    private int ID;
    private String name;

    public Student(int id, String n) {
        ID = id;
        name = n;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = "STUDENT { Name: " + name + ", ID " + ID + "; }";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student st = (Student) obj;
            return st.ID==ID && st.name.equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 42;
//        return ID;
        /*int hash=0;
        for (int i=0;i<name.length();i++) {
            hash+=(Integer.valueOf(name.charAt(i))*Math.pow(1, name.length()-i));
        }
        return (ID+hash);*/

        //return ID;
    }

    @Override
    public int compareTo(Student o) {
//            if (ID<o.getID()) return -1;
//            if (ID==o.getID()) return 0;
//            return 1;
        if (name.compareTo(o.getName())<0) return -1;
        if (name==o.getName()) return (ID-o.getID());
        return 1;
    }
}
