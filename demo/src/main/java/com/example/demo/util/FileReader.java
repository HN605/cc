package com.example.demo.util;

import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

import sun.misc.Cleaner;

/**
 * FileReader
 */
public class FileReader {

    public void clean(final MappedByteBuffer mappedByteBuffer) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

			@Override
			public Object run() {
                try {
                    Method cleanMethod = mappedByteBuffer.getClass().getMethod("clean", new Class[0]);
                    cleanMethod.setAccessible(true);
                    Cleaner cleaner = (Cleaner)cleanMethod.invoke(mappedByteBuffer, new Object[0]);
                    cleaner.clean();
                } catch (Exception e) {
                    e.printStackTrace();
                }
				return null;
			}
        });
    }
}