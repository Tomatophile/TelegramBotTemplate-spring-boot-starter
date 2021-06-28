package org.telegram.tomatophile.bottemplate.processed.command;

import org.telegram.tomatophile.bottemplate.processed.Processed;

public interface Command extends Processed {
    String getCommand();
}
