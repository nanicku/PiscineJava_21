package edu.school21.printer;

import edu.school21.render.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        prefix = " ";
    }

    public PrinterWithPrefixImpl() {
    }

    public void setPrefix(String source) {
        this.prefix = source;
    }

    @Override
    public void print(String str) {
        renderer.outputSource(prefix + " " + str);
    }
}
