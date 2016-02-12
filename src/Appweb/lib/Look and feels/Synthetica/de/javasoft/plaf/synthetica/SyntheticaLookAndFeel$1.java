// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 23/03/2011 22:27:50
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SyntheticaLookAndFeel.java

package de.javasoft.plaf.synthetica;

import de.javasoft.util.IVersion;
import java.awt.EventQueue;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

// Referenced classes of package de.javasoft.plaf.synthetica:
//            SyntheticaLookAndFeel

class SyntheticaLookAndFeel$1 extends Thread
{

    public void run()
    {
        do
        {
            try{Thread.sleep(millis);}catch(Exception e){}
            millis = (1800 + (new Random()).nextInt(3600)) * 1000;
            try
            {
                if(!dialogOpen)
                    EventQueue.invokeLater(new Runnable() {

                        public void run()
                        {}
                    });
            }
            catch(Exception e) { }
        } while(true);
    }


    private String createKey(TreeMap treemap)
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map mapentry;
        for(Iterator iterator = treemap.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(mapentry).append("\n"))
            mapentry = (java.util.Map)iterator.next();

        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        messagedigest.reset();
        messagedigest.update(stringbuilder.toString().getBytes("UTF-8"));
        byte abyte0[] = messagedigest.digest();
        StringBuilder stringbuilder1 = new StringBuilder(abyte0.length * 2);
        for(int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            if(j < 16)
                stringbuilder1.append('0');
            stringbuilder1.append(Integer.toHexString(j));
            if(i % 4 == 3 && i < abyte0.length - 1)
                stringbuilder1.append("-");
        }

        return stringbuilder1.toString().toUpperCase();
    }



    private boolean dialogOpen;
    private int millis;


    SyntheticaLookAndFeel$1()
    {
        millis = 15000;
    }
}