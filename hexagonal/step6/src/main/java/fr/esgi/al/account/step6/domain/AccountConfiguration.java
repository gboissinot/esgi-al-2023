package fr.esgi.al.account.step6.domain;

public record AccountConfiguration(long transferThreshold) {

    public long getTransferThreshold() {
        return transferThreshold;
    }
}
