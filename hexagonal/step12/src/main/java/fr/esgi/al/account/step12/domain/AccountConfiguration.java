package fr.esgi.al.account.step12.domain;

public record AccountConfiguration(long transferThreshold) {

    public long getTransferThreshold() {
        return transferThreshold;
    }
}
