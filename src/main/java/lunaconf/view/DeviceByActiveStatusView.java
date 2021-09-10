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

public class DeviceByActiveStatusView extends AbstractDeviceByActiveStatusView {

  public DeviceByActiveStatusView(ViewContext context) {}

  @Override
  public DeviceViewModel.DeviceByActiveStatusView emptyState() {
    return DeviceViewModel.DeviceByActiveStatusView.getDefaultInstance();
  }

  @Override
  public UpdateEffect<DeviceViewModel.DeviceByActiveStatusView> processDeviceCreated(
    DeviceViewModel.DeviceByActiveStatusView state, DeviceDomain.DeviceCreated deviceCreated) {
    if(!state.equals(DeviceViewModel.DeviceByActiveStatusView.getDefaultInstance()))
      return updateEffects().ignore();
    DeviceViewModel.DeviceByActiveStatusView newState = DeviceViewModel.DeviceByActiveStatusView.newBuilder().setDeviceId(deviceCreated.getDeviceId()).setActive(false).build();
    return updateEffects().updateState(newState);
  }
  @Override
  public UpdateEffect<DeviceViewModel.DeviceByActiveStatusView> processDeviceActivated(
    DeviceViewModel.DeviceByActiveStatusView state, DeviceDomain.DeviceActivated deviceActivated) {
    DeviceViewModel.DeviceByActiveStatusView newState = state.toBuilder().setActive(true).setCustomerId(deviceActivated.getCustomerId()).build();
    return updateEffects().updateState(newState);
  }
  @Override
  public UpdateEffect<DeviceViewModel.DeviceByActiveStatusView> ignoreOtherEvents(
    DeviceViewModel.DeviceByActiveStatusView state, Any any) {
    return updateEffects().ignore();
  }
}