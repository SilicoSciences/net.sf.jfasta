package net.sf.jfasta.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.jfasta.HeaderDialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderDialectUniprot implements HeaderDialect {

    private final static Logger log = LoggerFactory.getLogger(HeaderDialectUniprot.class);

    public final static String regex = ".*?([^\\s]+)\\s+.*OS=(.+).*GN=([^\\s]+).*";

    private String headerString;

    public HeaderDialectUniprot() {

    }

    public HeaderDialectUniprot(final String header) {
        setHeaderString(header);
    }

    public String getAccessions() {
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(getHeaderString());
        final boolean b = m.matches();
        if (b) {
            return m.group(1).trim();
        } else {
            if (log.isInfoEnabled()) {
                log.info("no accession for " + headerString);
            }
            return null;
        }
    }

    public String getGeneName() {
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(headerString);
        final boolean b = m.matches();
        if (b) {
            return m.group(3).trim();
        } else {
            if (log.isInfoEnabled()) {
                log.info("no gene name for " + headerString);
            }
            return null;
        }
    }

    public synchronized String getHeaderString() {
        return headerString;
    }

    public String getSpeciesName() {
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(headerString);
        final boolean b = m.matches();
        if (b) {
            return m.group(2).trim();
        } else {
            if (log.isInfoEnabled()) {
                log.info("no species name for " + headerString);
            }
            return null;
        }

    }

    public synchronized void setHeaderString(final String headerString) {
        if (headerString.startsWith(">")) {
            this.headerString = headerString.substring(1, headerString.length());
        } else {
            this.headerString = headerString;
        }
    }

}
