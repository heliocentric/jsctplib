 /*
 * Copyright (c) 2014, Telxir Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies, 
 * either expressed or implied, of the Telxir Project.
 * 
 */

package com.niftyengineering.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author helio
 * @param <T>
 */

public class QueuePair<T> implements IQueuePair<T> {
	public Boolean InUse;
	public Queue<T> Input;
	public Queue<T> Output;
	public int MessageID;
	public QueuePair() {
		this.MessageID = 0;
		this.constructor(new ConcurrentLinkedQueue<T>(),new ConcurrentLinkedQueue<T>());
	}
	public QueuePair(Queue<T> Input, Queue<T> Output) {
		this.InUse = true;
		this.constructor(Input, Output);
	}
    @Override
	public void Write(T message) {
        this.MessageID += 1;
        /*
		ev.setMessageID(this.MessageID);
        */
		this.Output.add(message);
	}
    @Override
    public T Read() {
        return this.Input.poll();
    }
	private void constructor(Queue<T> input, Queue<T> output) {
		this.Input = input;
		this.Output = output;
	}
}
