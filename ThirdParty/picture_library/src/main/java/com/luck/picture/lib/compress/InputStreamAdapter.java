package com.luck.picture.lib.compress;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:InputStreamAdapter.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * Automatically close the previous InputStream when opening a new InputStream,
 * and finally need to manually call {@link #close()} to release the resource.
 */
public abstract class InputStreamAdapter implements InputStreamProvider {

    private InputStream inputStream;

    @Override
    public InputStream open() throws IOException {
        close();
        inputStream = openInternal();
        return inputStream;
    }

    public abstract InputStream openInternal() throws IOException;

    @Override
    public void close() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException ignore) {
            } finally {
                inputStream = null;
            }
        }
    }
}