/* This code is managed by Akka Serverless tooling.
 * It will be re-generated to reflect any changes to your protobuf definitions.
 * DO NOT EDIT
 */
package lunaconf.view;

import com.akkaserverless.javasdk.view.View;
import com.akkaserverless.javasdk.view.ViewContext;
import com.google.protobuf.Any;
import java.util.function.Function;
import lunaconf.domain.DeviceDomain;

public class DeviceByCustomerView extends AbstractDeviceByCustomerView {

  public DeviceByCustomerView(ViewContext context) {}

  @Override
  public DeviceViewModel.DeviceByCustomerView emptyState() {
    return DeviceViewModel.DeviceByCustomerView.getDefaultInstance();
  }

  @Override
  public UpdateEffect<DeviceViewModel.DeviceByCustomerView> processDeviceActivated(
    DeviceViewModel.DeviceByCustomerView state, DeviceDomain.DeviceActivated deviceActivated) {
    if(!state.equals(DeviceViewModel.DeviceByCustomerView.getDefaultInstance()))
      return effects().ignore();
    DeviceViewModel.DeviceByCustomerView newState = DeviceViewModel.DeviceByCustomerView.newBuilder().setDeviceId(deviceActivated.getDeviceId()).setCustomerId(deviceActivated.getCustomerId()).setDeviceOn(false).build();
    return effects().updateState(newState);
  }

  @Override
  public UpdateEffect<DeviceViewModel.DeviceByCustomerView> processDeviceSwitchedOn(DeviceViewModel.DeviceByCustomerView state, DeviceDomain.DeviceSwitchedOn deviceSwitchedOn) {
    DeviceViewModel.DeviceByCustomerView newState = state.toBuilder().setDeviceOn(true).build();
    return effects().updateState(newState);
  }

  @Override
  public UpdateEffect<DeviceViewModel.DeviceByCustomerView> processDeviceSwitchedOff(DeviceViewModel.DeviceByCustomerView state, DeviceDomain.DeviceSwitchedOff deviceSwitchedOff) {
    DeviceViewModel.DeviceByCustomerView newState = state.toBuilder().setDeviceOn(false).build();
    return effects().updateState(newState);
  }

  @Override
  public UpdateEffect<DeviceViewModel.DeviceByCustomerView> ignoreOtherEvents(
    DeviceViewModel.DeviceByCustomerView state, Any any) {
    return effects().ignore();
  }
}