require 'calabash-android/abase'

class UserDetail < Calabash::ABase
  def trait
    "* id:'list_goods_llBlockInfo'"
  end


  def await(opts={})
    timeout = 10
    msg = "time out to wait for Login screen appear"
    options = {:timeout => timeout.to_i,
               :retry_frequency => 0.2,
               :post_timeout => 0.1,
               :timeout_message => msg}
    wait_for_elements_exist([trait], options)
    self
  end

  def check_order_exist(order, msg)
    sleep(1)
    should_see_text(order[:order_code])
    sleep(1)
    should_see_text(order[:amount] + " VND")
  end

end