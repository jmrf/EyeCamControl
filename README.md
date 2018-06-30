# EyeCamControl

Java Library to control G-Eye 300,500,700 and Xiaomi Yi

How the code works :

*   This code connect to ports 7878 and 8787 using TCP
*   It sends order and receive responses on the port 7878 in JSON
*   It use 8787 to download files from the camera files (in future to upload files too)

This code has been tested with Geye 500 camera but should work with model 300 and 700 too.
It should also work on camera based on the A7LS chipset. (Xiaomi Yi...)

A small program in console shows how to use the controler.

You can currently:

*   View/Modify an option on the camera
*   Take a photo (video is coming)
*   Download a file from yor camera

## Run

Your computer just need to be on the same network as the camera and the camera should use the address 192.168.42.1 (default one)

Otherwise, scan the network to find which IP address and port is using:

```bash
    ifconfig 	# determine the address
```

Should yield something like:

```bash
inet addr:10.15.12.101  Bcast:10.15.255.255 Mask:255.255.0.0

```

After that, using `nmap`:

```bash
    sudo nmap 10.15.12.0/24
```

Resulting in:

```bash
    Nmap scan report for 10.15.12.1
    Host is up (0.039s latency).
    Not shown: 996 closed ports
    PORT    STATE SERVICE
    21/tcp  open  ftp        # File Tranfer Protocol port
    80/tcp  open  http       # http server
    111/tcp open  rpcbind
    554/tcp open  rtsp       # Real Time Streaming Protocol port
```

Apparently for the new G-EYE 900 the default IP address is: `10.15.12.1`

First download the [json-simple-1.1.1.jar](http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm).

Then place it in `src/lib` and run:

```bash
    cd src

    # compile
    javac -cp lib/json-simple-1.1.1.jar:. Main.java

    # run
    java -cp lib/json-simple-1.1.1.jar:. Main
```

This should run an interactive command line example tool.
