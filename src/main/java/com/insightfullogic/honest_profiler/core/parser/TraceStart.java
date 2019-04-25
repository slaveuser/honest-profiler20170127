/**
 * Copyright (c) 2014 Richard Warburton (richard.warburton@gmail.com)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 **/
package com.insightfullogic.honest_profiler.core.parser;


import java.util.Objects;

public final class TraceStart implements LogEvent
{

    private final int numberOfFrames;
    private final long threadId;
    private final long timeSec;
    private final long timeNano;

    public TraceStart(int numberOfFrames, long threadId, long timeSec, long timeNano)
    {
        this.numberOfFrames = numberOfFrames;
        this.threadId = threadId;
        this.timeSec = timeSec;
        this.timeNano = timeNano;
    }

    public int getNumberOfFrames()
    {
        return numberOfFrames;
    }

    public long getThreadId()
    {
        return threadId;
    }

    public long getTraceEpoch()
    {
        return timeSec;
    }

    public long getTraceEpochNano()
    {
        return timeNano;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TraceStart that = (TraceStart) o;
        return Objects.equals(numberOfFrames, that.numberOfFrames)
            && Objects.equals(threadId, that.threadId)
            && Objects.equals(timeSec, that.timeSec)
            && Objects.equals(timeNano, that.timeNano);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(numberOfFrames, threadId, timeSec, timeNano);
    }

    @Override
    public void accept(LogEventListener listener)
    {
        listener.handle(this);
    }

    @Override
    public String toString()
    {
        return "TraceStart{" +
            "numberOfFrames=" + numberOfFrames +
            ", threadId=" + threadId +
            ", traceEpochSec=" + timeSec + 
            ", traceEpochNano=" + timeNano + 
            '}';
    }
}
