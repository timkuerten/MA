package controller;

import model.metadata.MetadataTable;
import model.metadata.UcumCode;
import model.metadata.UmlsCode;
import model.tuple.Pentuple;

import java.util.Collection;

public class MetadataTableController {

    MetadataTable mdt;

    public MetadataTableController() {
        mdt = new MetadataTable();
    }

    public MetadataTableController(MetadataTable mdt) {
        this.mdt = mdt;
    }

    public MetadataTableController(Collection<Pentuple<String, String, String, UmlsCode, UcumCode>> metadataTable) throws NullPointerException {
        mdt = new MetadataTable(metadataTable);
    }

    public void addLine(String schemaName, String tableName, String rowName, String umls, String ucum) {

    }


}
