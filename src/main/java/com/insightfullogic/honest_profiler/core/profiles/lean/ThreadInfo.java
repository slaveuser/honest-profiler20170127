package com.insightfullogic.honest_profiler.core.profiles.lean;

import com.insightfullogic.honest_profiler.core.parser.ThreadMeta;

public class ThreadInfo
{
    // Instance Properties

    private final long id;
    private String name;

    // Instance Constructors

    public ThreadInfo(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public ThreadInfo(ThreadMeta meta)
    {
        id = meta.getThreadId();
        name = meta.getThreadName();
    }

    // Instance Accessors

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public ThreadInfo checkAndSetName(String name)
    {
        if (name != null && !name.isEmpty())
        {
            this.name = name;
        }
        return this;
    }

    public String getIdentification()
    {
        StringBuilder result = new StringBuilder();
        result.append(name == null || name.isEmpty() ? "Unknown" : name);
        result.append(" <");
        result.append(id);
        result.append(">");
        return result.toString();
    }

    @Override
    // Generated by Eclipse
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    // Generated by Eclipse
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        ThreadInfo other = (ThreadInfo) obj;
        if (id != other.id)
        {
            return false;
        }

        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }

        return true;
    }
}
