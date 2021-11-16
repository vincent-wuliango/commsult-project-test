const server = express();

server.get("*", (req, res) => {
    return handle(req, res);
});

server.listen(port, err => {
    if(err) throw err;
    console.log(`Listening on PORT ${port}`);
});