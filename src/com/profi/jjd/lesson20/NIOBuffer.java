package com.profi.jjd.lesson20;

import java.nio.ByteBuffer;

public class NIOBuffer {
    /*ByteBuffer
    CharBuffer
    DoubleBuffer
    FloatBuffer
    IntBuffer
    LongBuffer
    ShortBuffer*/
    public static void main(String[] args) {
        // capacity - емкость (не меняется после установки)
        // position - текущая позиция в буфере (изначально 0)
        // limit - до какого значения можно читать / писать данные (изначально равен capacity)
        ByteBuffer buffer = ByteBuffer.allocate(16);
        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        assert anInt == buffer.getInt();
        assert aDouble == buffer.getDouble();

        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.compact();
        // VM options для включения assert: -ea
    }
}
