package statics;

public enum TypeClient {
    CA_NHAN("Cá Nhân"),
    DAI_DIEN_DON_VI_HANH_CHINH("Đại diện đơn vị hành chính"),
    DAI_DIEN_DON_VI_KINH_DOANH("Đại diện đơn vị kinh doanh");
    public String value;
    TypeClient(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TypeClient{" +
                "value='" + value + '\'' +
                '}';
    }
}
