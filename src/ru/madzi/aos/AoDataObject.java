package ru.madzi.aos;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

public class AoDataObject extends MultiDataObject {

    public AoDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-active-oberon", true);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(displayName = "#LBL_Ao_EDITOR",
    iconBase = "ru/madzi/aos/mail-in-a-bottle-icon.png",
    mimeType = "text/x-active-oberon",
    persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
    preferredID = "Ao",
    position = 1000)
    @Messages("LBL_Ao_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }
}
