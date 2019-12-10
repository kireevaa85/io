package ru.kireev.io;

import java.io.*;

public class DemoSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        deserialize(serialize());
    }

    private static byte[] serialize() throws IOException {
        try (var byteArrayOutputStream = new ByteArrayOutputStream();
             var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            var person = new Person(12, "SerialPersonForArray", "value");
            System.out.println("Serializing:" + person);
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }
    }

    private static void deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (var byteArrayInputStream = new ByteArrayInputStream(data);
             var objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            var person = objectInputStream.readObject();
            System.out.println("deSerialized person:" + person);
        }
    }

}
