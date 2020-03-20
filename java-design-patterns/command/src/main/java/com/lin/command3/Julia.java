package com.lin.command3;

/**
 * Client
 *
 * 这个例子写的不太好,客户端julia同时持有 接收者audioPlayer 调用者keypad 以及命令command
 *
 * 对于客户端来讲, 只需要两行代码就行了, 不关注命令最终谁执行.
 * //创建请求者，把命令对象设置进去
 * Invoker invoker = InvokerFactory.createInvoker(command);
 */
public class Julia {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        Command playCmd = new PlayCommand(audioPlayer);
        Command rewindCmd = new RewindCommand(audioPlayer);
        Command stopCmd = new StopCommand(audioPlayer);

        Kepad kepad = new Kepad();
        kepad.setPlayCommand(playCmd);
        kepad.setRewindCommand(rewindCmd);
        kepad.setStopCommand(stopCmd);
        kepad.play();
        kepad.rewind();
        kepad.stop();
    }
}
