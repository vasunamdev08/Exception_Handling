package assignment.q7;

class ResourceB implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from ResourceB.close()");
    }
}