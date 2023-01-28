package edu.school21.printer;

import edu.school21.render.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private Renderer renderer;
    private LocalDateTime dateTime;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
        this.dateTime = LocalDateTime.now();
    }

    public void setDateTime(LocalDateTime dataTime) {
        this.dateTime = dataTime;
    }

    @Override
    public void print(String str) {
        renderer.outputSource(dateTime + " " + str);
    }
}