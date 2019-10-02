# TestTool
I made this tool to help with the development of applications that use Sockets.

The "client" button will generate a Socket that will try to connect to the port determined by the spinner next to it.

If the "client" button does not generate a window, the client failed to connect, check if you have a server listening in that port.

The "Server" button will generate a ServerSocket that will be listening in the port determined by the spinner next to it.

If the "Server" button fails to generate a window, that port is already taken.

IMPORTANT: use the "Close" button to exit the application. Otherwise, the ports used by the tool will remain taken, and it may leave threads running.

If you exit the application without the "Close" button:

  You can kill the running threads (and free the used ports) by opening the Task Manager and killing the "Java(TM) Platform SE binary" task.
  
  It will be listed in background processes.
