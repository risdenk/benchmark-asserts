/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.apache.lucene;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
@State(Scope.Benchmark)
public class MyBenchmark {

  @State(Scope.Thread)
  public static class MyState {
    public long max_value = 10000000;
    public long assert_value = 10000000;
  }

  @Benchmark
  public long testNoAssert(MyState state) {
    long sum = 0L;
    for (long i = 0; i < state.max_value; i++) {
      sum += 1;
    }
    return sum;
  }

  @Benchmark
  public long testSimpleAssert(MyState state) {
    long sum = 0L;
    for (long i = 0; i < state.max_value; i++) {
      assert i < state.assert_value;
      sum += 1;
    }
    return sum;
  }

  @Benchmark
  public long testSimpleStringMessageAssert(MyState state) {
    long sum = 0L;
    for (long i = 0; i < state.max_value; i++) {
      assert i < state.assert_value : "hi";
      sum += 1;
    }
    return sum;
  }

  @Benchmark
  public long testLongStringMessageAssert(MyState state) {
    long sum = 0L;
    for (long i = 0; i < state.max_value; i++) {
      assert i < state.assert_value : "Lorem ipsum odor amet, consectetuer adipiscing elit. Taciti lacinia dictum natoque neque pretium ornare. Congue natoque fermentum penatibus pellentesque dignissim erat ultrices litora habitant. Diam mollis justo aptent ut velit. Mauris gravida felis convallis diam faucibus pretium scelerisque tellus. Cursus rutrum platea habitasse cubilia est per. Nullam pretium arcu tempor, neque curabitur eu. Netus dignissim et primis lacinia ad eleifend. Mi interdum molestie facilisis vel torquent per fermentum sagittis. Pulvinar convallis arcu est in suspendisse duis nulla curae. Laoreet efficitur adipiscing vulputate elit platea tempus sed himenaeos consectetur. Sed fames mus et litora ac lacus urna eros. Eleifend blandit id posuere orci interdum. Sollicitudin taciti dolor orci dictumst vivamus facilisis. Consectetur dui auctor nulla himenaeos sagittis morbi nam lacus condimentum. Pretium sociosqu consequat lorem hac, mus potenti dapibus diam. Habitant fusce sodales tempus dapibus nec habitant vel. Elementum iaculis curae gravida aliquet blandit nullam suscipit proin. Litora senectus at enim feugiat, fusce lacus hac. Massa cubilia cubilia habitasse ut volutpat, cubilia tempor. Pharetra rhoncus et facilisis ultrices tempus nibh. Mus habitant faucibus ad egestas egestas nisl amet potenti dolor. Ullamcorper justo fusce ante integer aliquam fames. Finibus aenean ante augue blandit praesent. Quis lacinia porttitor massa lectus magna vivamus sed primis. Magna natoque pretium malesuada a congue justo. Consectetur quisque semper phasellus consequat inceptos commodo. Sociosqu ullamcorper id ridiculus cras eros. Eros fringilla ornare habitant scelerisque dictum class mus porta. Congue neque tristique odio in nostra, mi vel. Morbi vitae id fermentum curabitur eget ipsum ante. Nisi pretium orci vehicula mus ac lectus integer. Fringilla facilisis conubia nunc porttitor sapien, mauris eget. Inceptos ex orci quisque; vivamus cursus at. Laoreet blandit est, montes nascetur eu lobortis mattis. Morbi conubia etiam condimentum enim adipiscing ad. Luctus porta feugiat conubia pellentesque nulla semper dis vel. Libero facilisi vestibulum senectus sed gravida ligula montes condimentum. the value of i is " + i;
      sum += 1;
    }
    return sum;
  }
}
