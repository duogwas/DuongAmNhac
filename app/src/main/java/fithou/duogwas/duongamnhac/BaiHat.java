package fithou.duogwas.duongamnhac; /*
 ** Created by duogwas on 06/11/2021
 **/

public class BaiHat {
    int id;
    int url;
    String name;

    public BaiHat(int id, int url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
