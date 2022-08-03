package QL_Ung_Vien.candidateType;

public class Certificated {
    private int CertificatedId;
    private String Certificated;
    private String CertificatedRank;
    private String CertificatedDate;

    public int getCertificatedId() {
        return CertificatedId;
    }
    public Certificated(){}
    public void setCertificatedId(int certificatedId) {
        CertificatedId = certificatedId;
    }

    public String getCertificated() {
        return Certificated;
    }

    public void setCertificated(String certificated) {
        Certificated = certificated;
    }

    public String getCertificatedRank() {
        return CertificatedRank;
    }

    public void setCertificatedRank(String certificatedRank) {
        CertificatedRank = certificatedRank;
    }

    public String getCertificatedDate() {
        return CertificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        CertificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Certificated{" +
                "CertificatedId=" + CertificatedId +
                ", Certificated='" + Certificated + '\'' +
                ", CertificatedRank='" + CertificatedRank + '\'' +
                ", CertificatedDate=" + CertificatedDate +
                '}';
    }
}
