/*
 *
 */
package org.jboss.dna.common.collection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author Randall Hauch
 */
public class UnmodifiableProperties extends Properties {

    private Properties delegate;

    public UnmodifiableProperties( Properties props ) {
        super();
        this.delegate = props != null ? props : new Properties();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Object clone() {
        return new UnmodifiableProperties(this.delegate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean contains( Object value ) {
        return delegate.contains(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey( Object key ) {
        return this.delegate.containsKey(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsValue( Object value ) {
        return this.delegate.containsValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Enumeration<Object> elements() {
        return this.delegate.elements();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals( Object o ) {
        return this.delegate.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object get( Object key ) {
        return this.delegate.get(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProperty( String key, String defaultValue ) {
        return this.delegate.getProperty(key, defaultValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProperty( String key ) {
        return this.delegate.getProperty(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.delegate.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Enumeration<Object> keys() {
        return this.delegate.keys();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void list( PrintStream out ) {
        this.delegate.list(out);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void list( PrintWriter out ) {
        this.delegate.list(out);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Enumeration<?> propertyNames() {
        return this.delegate.propertyNames();
    }

    /**
     * {@inheritDoc}
     * @deprecated
     */
    @Deprecated
    @Override
    public void save( OutputStream out, String comments ) {
        this.delegate.save(out, comments);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.delegate.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void store( OutputStream out, String comments ) throws IOException {
        this.delegate.store(out, comments);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void storeToXML( OutputStream os, String comment, String encoding ) throws IOException {
        this.delegate.storeToXML(os, comment, encoding);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void storeToXML( OutputStream os, String comment ) throws IOException {
        this.delegate.storeToXML(os, comment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.delegate.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Object> values() {
        return this.delegate.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entry<Object, Object>> entrySet() {
        return Collections.unmodifiableSet(super.entrySet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Object> keySet() {
        return Collections.unmodifiableSet(super.keySet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void load( InputStream inStream ) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void loadFromXML( InputStream in ) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Object put( Object key, Object value ) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void putAll( Map<? extends Object, ? extends Object> t ) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Object remove( Object key ) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Object setProperty( String key, String value ) {
        throw new UnsupportedOperationException();
    }

}
