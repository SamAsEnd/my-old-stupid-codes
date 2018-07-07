/*
 *
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.

 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle Corporation nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package example.manyballs;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;

/**
 * Class periodically repainting the canvas with all the balls.
 */
public class Repainter implements Runnable {

    /* target display */
    private Display display;
    /* canvas to repaint */
    private Canvas canvas;
    /* whether the repainting is stopped */
    private boolean stop;

    /**
     * Creates a new instance of repainter.
     *
     * @param display Target display
     * @param canvas  Canvas to repaint
     */
    public Repainter (Display display, Canvas canvas) {
        this.display = display;
        this.canvas = canvas;
    }

    /**
     * Starts the repainter
     */
    public void start () {
        stop = false;
        run ();
    }

    /**
     * Stops the repainter
     */
    public void stop () {
        stop = true;
    }

    /**
     * Actual repainting process being performed serially with actual display
     * updates.
     */
    public void run () {

        if (stop) {
            return;
        }

        try {
            // avoid insane repainting
            Thread.sleep (5);
        }
        catch (InterruptedException e) {
            // Never mind
        }

        canvas.repaint ();
        display.callSerially (this);
    }
}
