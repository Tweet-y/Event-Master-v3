package com.example.eventmaster.ui.viewmodel;

import com.example.eventmaster.data.repository.EventRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class EventViewModel_Factory implements Factory<EventViewModel> {
  private final Provider<EventRepository> repositoryProvider;

  public EventViewModel_Factory(Provider<EventRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public EventViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static EventViewModel_Factory create(
      javax.inject.Provider<EventRepository> repositoryProvider) {
    return new EventViewModel_Factory(Providers.asDaggerProvider(repositoryProvider));
  }

  public static EventViewModel_Factory create(Provider<EventRepository> repositoryProvider) {
    return new EventViewModel_Factory(repositoryProvider);
  }

  public static EventViewModel newInstance(EventRepository repository) {
    return new EventViewModel(repository);
  }
}
