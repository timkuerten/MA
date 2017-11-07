package model.metadata;

import model.tuple.Pentuple;

import java.util.*;

public class MetadataTable {

    // Schemaname, Tabellenname, Spaltename, UMLS, UCUM
    private List<Pentuple<String, String, String, UmlsCode, UcumCode>> metadataTable;

    public MetadataTable() {
        metadataTable = new ArrayList<>();
    }

    public MetadataTable(Collection<Pentuple<String, String, String, UmlsCode, UcumCode>> metadataTable) throws NullPointerException{
        super();
        setMetadataTable(metadataTable);
    }

    private boolean doesTableExtendSchema(Collection<Pentuple<String, String, String, UmlsCode, UcumCode>> metadataTable) {
        for (Pentuple<String, String, String, UmlsCode, UcumCode> tableEntry : metadataTable) {
            if (tableEntry.getFirst() == null || tableEntry.getFirst().equals("")) {
                //throw new NullPointerException("Das Schema eines Eintags entspricht nicht den Vorgaben (nicht null oder leer)!");
                return false;
            } else if (tableEntry.getSecond() == null || tableEntry.getSecond().equals("")) {
                //throw new NullPointerException("Der Tabellenname eines Eintags entspricht nicht den Vorgaben (nicht null oder leer)!");
                return false;
            } else if (tableEntry.getThird() == null || tableEntry.getThird().equals("")) {
                //throw new NullPointerException("Der Spaltenname eines Eintags entspricht nicht den Vorgaben (nicht null oder leer)!");
                return false;
            }
        }

        return true;
    }

    private void setMetadataTable(Collection<Pentuple<String, String, String, UmlsCode, UcumCode>> metadataTable) throws NullPointerException {
        if (metadataTable == null) {
            throw new NullPointerException("metadataTable ist null");
        } else if (metadataTable.isEmpty()) {
            this.metadataTable = new ArrayList<>();
        } else if (!doesTableExtendSchema(metadataTable)) {
            throw new NullPointerException("Mindestens ein Eintrag des Schemas, Tabellennamens oder des Spaltennamens entspricht nicht den Vorgaben (nicht null oder leer)!");
        } else {
            if (metadataTable instanceof List)
                this.metadataTable = (List<Pentuple<String, String, String, UmlsCode, UcumCode>>)metadataTable;
            else {
                this.metadataTable = new ArrayList<>();
                this.metadataTable.addAll(metadataTable);
            }

            sortMetadataTable();
        }
    }

    public List<Pentuple<String, String, String, UmlsCode, UcumCode>> getMetadataTable() {
        return metadataTable;
    }

    private boolean doesMetadataTableExist() {
        return (metadataTable != null);
    }

    public boolean isEmplty() throws NullPointerException {
        if (!doesMetadataTableExist()) {
            throw new NullPointerException("Metadatentabelle existiert nicht!");
        }

        return metadataTable.isEmpty();
    }

    private void sortMetadataTable() {
        metadataTable.sort((p1, p2) -> {

            int comparison = p1.getFirst().compareTo(p2.getFirst());

            if (comparison != 0) {
                return comparison;
            } else {
                comparison = p1.getSecond().compareTo(p2.getSecond());
                if (comparison != 0) {
                    return comparison;
                } else {
                    comparison = p1.getThird().compareTo(p2.getThird());
                    if (comparison != 0) {
                        return comparison;
                    } else {
                        // TODO: Was bei komplett identischen Daten machen?
                        return 0;
                    }
                }
            }
        });
    }


}
