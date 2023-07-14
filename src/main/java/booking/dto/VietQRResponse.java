package booking.dto;

public class VietQRResponse {
    private String code;
    private String desc;
    private Data data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private int acpId;
        private String accountName;
        private String qrCode;
        private String qrDataURL;

        public int getAcpId() {
            return acpId;
        }

        public void setAcpId(int acpId) {
            this.acpId = acpId;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getQrDataURL() {
            return qrDataURL;
        }

        public void setQrDataURL(String qrDataURL) {
            this.qrDataURL = qrDataURL;
        }
    }
}
